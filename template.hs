import Data.List
import Text.Printf

main :: IO ()
main = interact $
  unlines . zipWith output [1..] . map (solve.words) . tail . lines

output :: Int -> Double -> String
output testCase res = printf "Case #%d: %.10f" testCase res

solve :: [String] -> Double
solve (cmd: x)
  | cmd == "mean" = sum a / (fromIntegral $ length list)
  | cmd == "median" = sort a !! (length list `div` 2)
  where a = map read $ list
        list = tail x
